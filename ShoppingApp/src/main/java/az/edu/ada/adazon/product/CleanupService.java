package az.edu.ada.adazon.product;

import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class CleanupService {

    @Value("${app.uploaded.images.path}")
    private String uploadedImagesPath;

    @PostConstruct
    public void cleanupUploadedImagesOnStart() {
        try {
            Path uploadedDir = Paths.get(uploadedImagesPath);
            if (Files.exists(uploadedDir) && Files.isDirectory(uploadedDir)) {
                try (Stream<Path> files = Files.list(uploadedDir)) {
                    if (files.findAny().isPresent()) {
                        Files.walk(uploadedDir)
                                .map(Path::toFile)
                                .filter(File::isFile)
                                .forEach(File::delete);
                        System.out.println("Directory content cleared: " + uploadedDir);
                    } else {
                        System.out.println("Directory is empty, skipping cleanup: " + uploadedDir);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
