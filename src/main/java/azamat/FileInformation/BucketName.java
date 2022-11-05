package azamat.FileInformation;

import lombok.Getter;

@Getter
public enum BucketName {


    AWS_BOOKS("kuttubek");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

}