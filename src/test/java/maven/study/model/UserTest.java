package maven.study.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    
    @Test
    void test() {
        //private 생성자에 빌더 적용시 빌더 정상 동작함
        User test = User.builder()
                .id(1L)
                .name("test")
                .build();

        System.out.println("test.getName() = " + test.getName());
    }

}