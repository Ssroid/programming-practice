package org.sunms.designpattern.structural.composite;

/**
 * 컴포지트 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 */
public class MainComposite {

    /**
     * 파일이든 폴더든 똑같이 받아서 크기를 출력합니다.
     *
     * @param item 정보를 출력할 항목 (파일 또는 폴더)
     */
    static void showInfo(FileSystemItemComposite item) {
        System.out.println("  '" + item.getName() + "' 의 크기 = " + item.getSize() + "KB");
    }

    /**
     * <b>컴포지트 패턴(Composite Pattern)</b>: "하나짜리(파일)"와 "여러 개를 담은 묶음(폴더)"을
     * 똑같은 방법으로 다루는 구조 패턴입니다. (트리 구조를 표현할 때 사용)
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>폴더 안에는 파일도 있고, 또 다른 폴더도 있습니다. (폴더 안의 폴더 안의 ...)
     * "전체 용량 계산"을 하려면?</p>
     * <pre>{@code
     * if (item instanceof File)        → 파일 크기 더하기
     * else if (item instanceof Folder) → 그 안을 또 뒤져서 ... (if 문 지옥)
     * }</pre>
     * <p>→ 사용하는 쪽에서 매번 "이게 파일이야, 폴더야?"를 구분해야 해서 복잡해집니다.</p>
     *
     * <h4>해결 방법</h4>
     * <p>파일과 폴더가 "같은 인터페이스({@link FileSystemItemComposite})"를 구현하게 합니다.</p>
     * <ul>
     *   <li>파일의 {@code getSize()} → 자기 크기 반환</li>
     *   <li>폴더의 {@code getSize()} → 안에 든 것들에게 {@code getSize()}를 물어서 합산 (재귀!)</li>
     * </ul>
     * <p>→ 사용하는 쪽은 그냥 {@code item.getSize()}만 부르면 끝!</p>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Component</b>: {@link FileSystemItemComposite} (파일/폴더 공통 규격, 인터페이스)</li>
     *   <li><b>Leaf</b>: {@link FileComposite} (자식이 없는 끝 노드, 파일)</li>
     *   <li><b>Composite</b>: {@link FolderComposite} (자식을 담는 그릇, 폴더)</li>
     * </ul>
     *
     * <h4>실생활 비유</h4>
     * <p>회사 조직도: 팀원(Leaf) / 팀(Composite, 팀원과 하위 팀을 포함)<br>
     * "총 인건비는?" → 회사에 물어보면 각 부서 → 각 팀 → 각 팀원 순으로 합산</p>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 복잡한 트리 구조를 단순하게 처리, 새 종류 추가 쉬움</li>
     *   <li><b>단점</b>: 설계가 너무 일반화되어, "폴더에만 파일 추가 가능" 같은 제약을 표현하기 애매할 수 있음</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>파일 시스템 ({@code java.io.File}은 파일/디렉터리를 같은 클래스로 다룸)</li>
     *   <li>GUI 컴포넌트: 패널(Container) 안에 버튼, 또 다른 패널...</li>
     *   <li>HTML DOM 트리, 메뉴/하위메뉴, 카테고리 트리</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {

        // 트리 구조 만들기
        //   내 문서/
        //   ├── 이력서.pdf
        //   ├── 사진/
        //   │   ├── 여행.jpg
        //   │   └── 2026/
        //   │       └── 졸업식.jpg
        //   └── 메모.txt
        FolderComposite photos2026 = new FolderComposite("2026")
                .add(new FileComposite("졸업식.jpg", 3000));

        FolderComposite photos = new FolderComposite("사진")
                .add(new FileComposite("여행.jpg", 2500))
                .add(photos2026);                           // 폴더 안에 폴더!

        FolderComposite myDocs = new FolderComposite("내 문서")
                .add(new FileComposite("이력서.pdf", 200))
                .add(photos)
                .add(new FileComposite("메모.txt", 5));

        System.out.println("===== 1. 전체 구조 출력 =====");
        myDocs.print("  ");

        System.out.println();
        System.out.println("===== 2. 파일과 폴더를 똑같이 다루기 =====");
        showInfo(new FileComposite("메모.txt", 5));   // 파일을 넘겨도
        showInfo(photos);                             // 폴더를 넘겨도
        showInfo(myDocs);                             // 큰 폴더를 넘겨도 → 같은 코드로 동작!
    }
}
