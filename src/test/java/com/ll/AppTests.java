package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static com.ll.TestUtil.genScanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTests {
    @Test
    public void 테스트() {
        assertTrue(1 == 1);
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("스캐너에_키보드가_아닌_문자열을_입력으로_설정")
    public void t1() {
        Scanner sc = genScanner("안녕");

        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);
    }

    @Test
    @DisplayName("출력을 모니터에 하지 않고 문자열로 얻기")
    public void t2() {
        //sout 에 대한 화면출력 금지 시작
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        //그 동안 출력되지 않던 내용들을 문자열로 반환
        String rs = output.toString();

        //sout에 대한 화면출력 금지 끝
        TestUtil.clearSetOutToByteArray(output);

        assertEquals("안녕", rs);
    }
}