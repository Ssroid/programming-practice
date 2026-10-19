package org.sunms.designpattern.structural.proxy;

/**
 * 진짜 이미지 대신 먼저 만들어 두는 가벼운 대리인입니다.
 *
 * <p><b>역할:</b> Proxy (대리인)</p>
 *
 * <h2>동작 방식</h2>
 * <ol>
 *   <li>생성될 때는 파일 이름만 기억함 → 아주 가볍고 빠름</li>
 *   <li>{@link #display()}가 "처음" 호출되면 그때 진짜 이미지({@link RealImageProxy})를 생성</li>
 *   <li>두 번째부터는 이미 만들어 둔 진짜 이미지를 재사용</li>
 * </ol>
 *
 * @see RealImageProxy
 */
public class LazyImageProxy implements ImageProxy {   // 진짜와 같은 인터페이스 구현!

    /** 이미지 파일 이름 */
    private final String fileName;

    /** 진짜 이미지. 처음엔 {@code null} (아직 진짜를 안 만듦) */
    private RealImageProxy realImage;

    /**
     * 대리인을 만듭니다. 파일 이름만 기억하고 로딩은 하지 않습니다.
     *
     * @param fileName 이미지 파일 이름
     */
    public LazyImageProxy(String fileName) {
        this.fileName = fileName;
        System.out.println("    (프록시 생성: '" + fileName + "' 이름만 기억, 로딩은 나중에)");
    }

    /**
     * 이미지를 보여줍니다. 처음 호출될 때만 진짜 이미지를 로딩하고,
     * 실제 표시는 진짜 이미지에게 맡깁니다. (위임)
     */
    @Override
    public void display() {
        if (realImage == null) {                       // 진짜가 아직 없으면
            System.out.println("    [프록시] 처음 요청됨 → 이제서야 진짜 이미지를 로딩합니다.");
            realImage = new RealImageProxy(fileName);  // 이때 비로소 생성!
        } else {
            System.out.println("    [프록시] 이미 로딩됨 → 재사용");
        }
        realImage.display();                           // 실제 일은 진짜에게 맡김 (위임)
    }
}
