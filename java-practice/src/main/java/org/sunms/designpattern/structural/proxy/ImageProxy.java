package org.sunms.designpattern.structural.proxy;

/**
 * "이미지라면 화면에 보여줄 수 있어야 한다({@link #display()})"는 규격입니다.
 *
 * <p><b>역할:</b> Subject (진짜 객체와 대리인의 공통 규격)<br>
 * 패턴 전체 설명은 {@link MainProxy#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>진짜 이미지({@link RealImageProxy})와 대리인({@link LazyImageProxy})이 모두 이 규격을 구현합니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가? ★ 프록시 패턴의 핵심 ★</h2>
 * <p>사용하는 쪽 몰래 "진짜 대신 대리인을 슬쩍 끼워 넣기" 위해서입니다.</p>
 * <pre>{@code
 * List<ImageProxy> album = List.of(new RealImageProxy(...));   // 진짜를 넣어도
 * List<ImageProxy> album = List.of(new LazyImageProxy(...));   // 대리인을 넣어도
 * album.get(0).display();                                      // 사용 코드는 똑같음!
 * }</pre>
 * <p>→ 앨범 코드는 한 줄도 바꾸지 않고, 지연 로딩/권한 체크/캐싱 같은 기능을 끼워 넣을 수 있습니다.</p>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>사용하는 쪽이 {@code List<RealImageProxy>}처럼 "진짜 클래스"에 직접 의존하면,
 * 대리인을 끼워 넣으려 할 때 사용하는 쪽 코드를 전부 찾아서 고쳐야 합니다.<br>
 * → 스프링의 {@code @Transactional}이 동작하는 원리도 이것입니다.
 * 우리가 인터페이스(또는 상위 타입)로 주입받기 때문에, 스프링이 몰래 프록시를 넣어 줄 수 있습니다.</p>
 *
 * @see RealImageProxy
 * @see LazyImageProxy
 */
public interface ImageProxy {

    /**
     * 이미지를 화면에 보여줍니다.
     */
    void display();
}
