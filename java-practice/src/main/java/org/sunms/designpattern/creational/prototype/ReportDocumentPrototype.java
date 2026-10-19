package org.sunms.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 보고서 문서입니다. {@link #copy()}를 호출하면 나와 똑같은 보고서를 하나 더 만들어 줍니다.
 *
 * <p><b>역할:</b> Concrete Prototype (실제로 복사되는 객체)</p>
 *
 * @see DocumentPrototype
 * @see TemplateRegistryPrototype
 */
public class ReportDocumentPrototype implements DocumentPrototype {

    /** 제목. {@code String}은 값처럼 동작해서 복사 걱정이 없습니다. */
    private String title;
    /** 작성자 */
    private String author;
    /** 목차. {@code List}는 참조 타입이므로 복사할 때 주의해야 합니다! */
    private List<String> sections;

    /**
     * 보고서를 만듭니다.
     *
     * @param title    제목
     * @param author   작성자
     * @param sections 목차 목록 (내부에서 새 리스트로 복사해서 보관)
     */
    public ReportDocumentPrototype(String title, String author, List<String> sections) {
        this.title = title;
        this.author = author;
        this.sections = new ArrayList<>(sections);
    }

    /**
     * ★ 깊은 복사로 나와 똑같은 보고서를 만듭니다.
     *
     * <p>{@code new ArrayList<>(this.sections)}는 리스트를 "새로" 만들고 내용물만 옮겨 담습니다.
     * 그래서 복사본의 목차를 바꿔도 원본 목차는 그대로입니다.</p>
     *
     * <p><b>만약 얕은 복사를 했다면?</b></p>
     * <pre>{@code
     * copy.sections = this.sections;   // 주소만 복사 → 같은 리스트를 공유
     * }</pre>
     * <p>→ 복사본에 목차를 추가하면 원본에도 추가되어 버립니다. (버그)</p>
     *
     * @return 원본과 독립적인 새 보고서
     */
    @Override
    public ReportDocumentPrototype copy() {
        return new ReportDocumentPrototype(this.title, this.author, new ArrayList<>(this.sections));
    }

    /**
     * 제목을 바꿉니다. (복사 후 수정할 때 사용)
     *
     * @param title 새 제목
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 작성자를 바꿉니다. (복사 후 수정할 때 사용)
     *
     * @param author 새 작성자
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 목차를 하나 추가합니다. (복사 후 수정할 때 사용)
     *
     * @param section 추가할 목차
     */
    public void addSection(String section) {
        this.sections.add(section);
    }

    /**
     * 보고서 내용을 보기 좋게 문자열로 만듭니다.
     *
     * @return 보고서 정보
     */
    @Override
    public String toString() {
        return "보고서 [제목=" + title + ", 작성자=" + author + ", 목차=" + sections + "]";
    }
}
