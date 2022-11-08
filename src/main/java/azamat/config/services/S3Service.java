package azamat.config.services;

import azamat.FileInformation.BucketName;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class S3Service {

    private final AmazonS3Client awsS3Client;


    public void deleteFile(String keyName) {
        final DeleteObjectRequest deleteObjectRequest = new
                DeleteObjectRequest(BucketName.AWS_BOOKS.getBucketName(), "Images/"+keyName);
        awsS3Client.deleteObject(deleteObjectRequest);
    }
}
