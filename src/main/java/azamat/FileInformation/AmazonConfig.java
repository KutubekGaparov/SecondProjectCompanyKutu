package azamat.FileInformation;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Getter @Setter
public class AmazonConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String AWS_ACCESS_KEY_ID;

    @Value("${cloud.aws.credentials.secret-key}")
    private String AWS_SECRET_ACCESS_KEY;

    @Value("${cloud.aws.region.static}")
    private String REGION;

    @Bean
    @Primary
    public AmazonS3 s3client() {

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(REGION))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

    }
}