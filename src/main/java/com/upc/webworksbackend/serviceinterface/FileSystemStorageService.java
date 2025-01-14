package com.upc.webworksbackend.serviceinterface;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService {
@Value("${media.location}")
private String mediaLocation;

private Path rootLocation;

 @PostConstruct
 public void init() throws IOException{
    rootLocation=Paths.get(mediaLocation);
    Files.createDirectories(rootLocation);
}

  public String store(MultipartFile file){
    try {
        if(file.isEmpty()){
            throw new RuntimeException("Empty file");
        }
        String fileName = file.getOriginalFilename();
        if(fileName !=null){
            Path destinationFile=rootLocation.resolve(Paths.get(fileName))
                    .normalize().toAbsolutePath();
            try (InputStream inputStream =file.getInputStream()){
                Files.copy(inputStream,destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        return fileName;
    }catch (IOException e){
      throw new RuntimeException("Failed to store file",e);
    }

}

  public Resource loadResource(String fileName){
try{
    Path file=rootLocation.resolve(fileName);
    Resource resource=new UrlResource((file.toUri()));

    if(resource.exists() || resource.isReadable()){
        return resource;
    }else{
        throw new RuntimeException("File not found" + fileName);
    }

}catch (MalformedURLException e){
    throw new RuntimeException("Failed to load file" + fileName);
}
}


}
