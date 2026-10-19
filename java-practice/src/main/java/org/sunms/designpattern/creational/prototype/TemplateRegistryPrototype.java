package org.sunms.designpattern.creational.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 자주 쓰는 원본(템플릿)들을 이름표를 붙여 보관해 두는 보관함입니다.
 * 요청이 오면 원본을 "그대로 주지 않고" 복사본을 만들어 줍니다.
 *
 * <p><b>역할:</b> Prototype Registry (원본 보관함, 선택 사항)</p>
 *
 * <h2>왜 원본을 그대로 주면 안 되나?</h2>
 * <p>누군가 받은 객체를 수정하면 원본 템플릿이 망가지기 때문입니다!</p>
 *
 * @see ReportDocumentPrototype
 */
public class TemplateRegistryPrototype {

    /** 템플릿 이름 → 원본 문서 */
    private final Map<String, ReportDocumentPrototype> templates = new HashMap<>();

    /**
     * 보관함을 만들고 원본 템플릿("주간보고", "회의록")을 등록합니다.
     * 원본은 프로그램 시작 시 한 번만 만듭니다. (생성 비용이 크다고 가정)
     */
    public TemplateRegistryPrototype() {
        templates.put("주간보고", new ReportDocumentPrototype(
                "주간 업무 보고", "(작성자 미정)", List.of("1. 이번 주 한 일", "2. 다음 주 할 일")));
        templates.put("회의록", new ReportDocumentPrototype(
                "회의록", "(작성자 미정)", List.of("1. 참석자", "2. 안건", "3. 결정 사항")));
    }

    /**
     * 원본 템플릿을 복사해서 돌려줍니다.
     *
     * @param templateName 템플릿 이름 (예: "주간보고")
     * @return 원본이 아닌 복사본
     * @throws IllegalArgumentException 등록되지 않은 템플릿 이름일 때
     */
    public ReportDocumentPrototype create(String templateName) {
        ReportDocumentPrototype original = templates.get(templateName);
        if (original == null) {
            throw new IllegalArgumentException("없는 템플릿입니다: " + templateName);
        }
        return original.copy();   // ★ 원본이 아니라 복사본!
    }

    /**
     * 원본 상태를 확인합니다. (원본이 바뀌지 않았는지 확인하는 학습용 메서드)
     *
     * @param templateName 템플릿 이름
     * @return 원본 문서 (수정하지 마세요!)
     */
    public ReportDocumentPrototype peekOriginal(String templateName) {
        return templates.get(templateName);
    }
}
