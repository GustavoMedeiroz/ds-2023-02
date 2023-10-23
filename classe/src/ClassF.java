import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class ClassF {
    public static void main(String[] args) {
        
        if(args.length < 2) {
            System.err.println("Argumentos: <nome da classe> <diretório> [-p]");
            System.exit(1);
        }

        String targetClassName = args[0];
        String directoryPath = args[1];
        boolean useParallel = (args.length > 2 && args[2].equals("-p"));

        long startTime = System.currentTimeMillis();

        Path directory = Paths.get(directoryPath);

        if(!Files.exists(directory) || !Files.isDirectory(directory)) {
            System.err.println("O diretório especificado não existe ou não é um diretório válido.");
            System.exit(1);
        }

        List<Path> foundClassFiles = new ArrayList<>();

        try {
            Stream<Path> fileStream = useParallel ? Files.walk(directory).parallel() : Files.walk(directory);

            foundClassFiles = fileStream
                .filter(file -> isJavaClassFile(file) && containsClassName(file, targetClassName))
                .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        printResults(startTime, foundClassFiles);
    }

    private static boolean isJavaClassFile(Path filePath) {
        return Files.isRegularFile(filePath) && filePath.getFileName().toString().toLowerCase().endsWith(".class");
    }

    private static boolean containsClassName(Path filePath, String targetClassName) {
        try {
            byte[] fileBytes = Files.readAllBytes(filePath);
            String fileContent = new String(fileBytes);
            return fileContent.contains(targetClassName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void printResults(long startTime, List<Path> foundClassFiles) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        if (foundClassFiles.isEmpty()) {
            System.out.println("A classe não foi encontrada em nenhum arquivo .class.");
        } else {
            System.out.println("A classe foi encontrada nos seguintes locais:");
            for (Path path : foundClassFiles) {
                System.out.println(path);
            }
        }

        System.out.println("Tempo gasto: " + duration + " ms");
        System.out.println("Número de arquivos consultados: " + foundClassFiles.size());
    }
}
