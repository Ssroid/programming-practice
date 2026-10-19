package org.sunms.designpattern.structural.facade;

/**
 * 홈시어터의 프로젝터입니다.
 *
 * <p><b>역할:</b> Subsystem (복잡한 내부 부품 ①)</p>
 *
 * @see HomeTheaterFacade
 */
public class ProjectorFacade {

    /** 프로젝터를 켭니다. */
    public void on() {
        System.out.println("    프로젝터 ON");
    }

    /** 화면비를 16:9 와이드 모드로 설정합니다. */
    public void setWideScreenMode() {
        System.out.println("    프로젝터 화면비 16:9 와이드 모드 설정");
    }

    /** 프로젝터를 끕니다. */
    public void off() {
        System.out.println("    프로젝터 OFF");
    }
}
