package com.binara;

import com.binara.controller.grpc.StudentGrpc;
import com.binara.controller.grpc.StudentRequest;
import com.binara.controller.grpc.StudentResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

/**
 * Created by binara on 7/2/17.
 */
public class SpringGrpcClient {

    public static final String AUTH_SERVER_URI = "http://localhost:8080/SpringSecurityOAuth2ORMgRPC/oauth/token";

    public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=def&password=456";

    public static final String QPM_ACCESS_TOKEN = "?access_token=";

//    private static final Logger LOGGER = Logger.getLogger(SpringGrpcClient.class.getName());

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081).usePlaintext(true).build();
        StudentGrpc.StudentBlockingStub blockingStub = StudentGrpc.newBlockingStub(channel);

        System.out.println();

        for (int i=0; i<3; i++) {
            fetchStudent(blockingStub, i);
        }
    }

    private static void fetchStudent(StudentGrpc.StudentBlockingStub blockingStub, int id) {
        StudentRequest request = StudentRequest.newBuilder().setId(id).build();
        try {
            StudentResponse response = blockingStub.getStudent(request);
            System.out.println("[" + response.getId() + ", " + response.getName() + ", " + response.getAge() + "]");
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus());
        }
    }

}
