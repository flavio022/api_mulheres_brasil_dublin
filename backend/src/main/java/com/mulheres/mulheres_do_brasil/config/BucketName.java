package com.mulheres.mulheres_do_brasil.config;

public enum BucketName {
    PROFILE_IMAGE("mulheres-brasil-dub");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }
    public String getBucketName() {
        return bucketName;
    }
}

