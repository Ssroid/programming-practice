package org.sunms.designpattern.structural.proxy;

/**
 * 실제 고화질 이미지입니다. 생성될 때 디스크에서 파일을 읽어 오므로 "무겁고 느립니다".
 *
 * <p><b>역할:</b> Real Subject (진짜 객체)</p>
 *
 * @see LazyImageProxy
 */
public class RealImageProxy implements ImageProxy {

    /** 이미지 파일 이름 */
    private final String fileName;

    /**
     * 이미지를 만들면서 곧바로 디스크에서 로딩합니다. (생성자에서 바로 무거운 작업을 수행!)
     *
     * @param fileName 이미지 파일 이름
     */
    public RealImageProxy(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    /**
     * 디스크에서 이미지를 읽어 옵니다. 0.5초가 걸린다고 가정합니다.
     */
    private void loadFromDisk() {
        System.out.println("    (디스크에서 '" + fileName + "' 로딩 중... 무거운 작업!)");
        try {
            Thread.sleep(500);   // 로딩에 시간이 걸린다고 가정 (0.5초)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 화면에 이미지를 표시합니다.
     */
    @Override
    public void display() {
        System.out.println("    [이미지] 화면에 '" + fileName + "' 표시");
    }
}
