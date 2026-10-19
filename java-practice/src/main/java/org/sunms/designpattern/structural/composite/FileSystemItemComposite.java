package org.sunms.designpattern.structural.composite;

/**
 * "파일 시스템 안의 항목이라면 이름, 크기, 출력 기능이 있어야 한다"는 규격입니다.
 *
 * <p><b>역할:</b> Component (파일과 폴더의 공통 규격)<br>
 * 패턴 전체 설명은 {@link MainComposite#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>파일(Leaf)과 폴더(Composite)가 모두 이 규격을 구현합니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가? ★ 컴포지트 패턴의 핵심 ★</h2>
 * <ol>
 *   <li>폴더가 파일과 폴더를 "한 리스트"에 섞어 담을 수 있게 하기 위해서입니다.
 *       <pre>{@code
 * List<FileSystemItemComposite> children;   // 파일도 OK, 폴더도 OK
 * }</pre></li>
 *   <li>폴더의 {@code getSize()}가 자식이 무엇인지 구분하지 않고 재귀로 계산할 수 있게 하기 위해서입니다.
 *       <pre>{@code
 * for (FileSystemItemComposite child : children) total += child.getSize();
 * // 자식이 파일이면 자기 크기를, 폴더면 또 자기 자식들을 합산해서 돌려줌
 * }</pre></li>
 * </ol>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>폴더는 {@code List<FileComposite>}와 {@code List<FolderComposite>}를 따로 들고 있어야 하고,
 * 크기 계산, 출력 등 모든 기능마다 "파일이면 ~, 폴더면 ~" 하는 if 문을 써야 합니다.
 * 바로가기(Shortcut) 같은 새 항목이 생기면 그 if 문을 전부 찾아서 고쳐야 하죠.<br>
 * → 인터페이스로 추상화하면 "하나"와 "묶음"을 같은 코드로 다룰 수 있습니다.</p>
 *
 * @see FileComposite
 * @see FolderComposite
 */
public interface FileSystemItemComposite {

    /**
     * 항목 이름을 알려줍니다.
     *
     * @return 파일 또는 폴더 이름
     */
    String getName();

    /**
     * 크기를 알려줍니다. 폴더라면 안에 든 모든 항목의 크기 합계입니다.
     *
     * @return 크기 (KB)
     */
    int getSize();

    /**
     * 구조를 화면에 출력합니다.
     *
     * @param indent 앞에 붙일 들여쓰기 문자열
     */
    void print(String indent);
}
