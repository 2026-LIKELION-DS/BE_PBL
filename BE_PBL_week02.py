# 아기 사자 등록 
def add_lion(lions):
    name = input("이름을 입력하세요: ").strip()
    if name == "":
        print("이름이 비어있습니다.")
        return

    track = input("트랙을 입력하세요: ").strip()
    if track == "":
        print("트랙이 비어있습니다.")
        return

    try:
        generation = int(input("기수를 입력하세요: ").strip())
    except ValueError:
        print("기수는 숫자로 입력해야 합니다.")
        return

    # 아기 사자 정보 딕셔너리로 관리
    lion = {
        "name": name,
        "track": track,
        "generation": generation
    }

    # 리스트에 추가
    lions.append(lion)
    print("아기사자 등록 완료.")

# 검색 함수
def search_by_name(lions):
    target = input("검색할 이름을 입력하세요: ").strip()

    found = False
    for lion in lions:
        if lion["name"] == target:
            print(f"이름: {lion['name']}, 트랙: {lion['track']}, 기수: {lion['generation']}")
            found = True

    if not found:
        print("해당 이름의 아기사자를 찾을 수 없습니다.")

# 조회 함수
def filter_by_track(lions):
    target = input("조회할 트랙을 입력하세요: ").strip()

    results = []
    for lion in lions:
        if lion["track"] == target:
            results.append(lion)

    if len(results) == 0:
        print("해당 트랙의 아기사자가 없습니다.")
    else:
        for lion in results:
            print(f"이름: {lion['name']}, 트랙: {lion['track']}, 기수: {lion['generation']}")

# 기능 선택 함수
def print_menu():
    print("\n===== 아기사자 관리 프로그램 =====")
    print("1. 아기사자 등록")
    print("2. 이름 검색")
    print("3. 트랙별 조회")
    print("4. 종료")


def main():
    lions = []

    while True:
        print_menu()
        choice = input("메뉴를 선택하세요: ").strip()

        if choice == "1":
            add_lion(lions)
        elif choice == "2":
            search_by_name(lions)
        elif choice == "3":
            filter_by_track(lions)
        elif choice == "4":
            print("프로그램을 종료합니다.")
            break
        else:
            print("잘못된 입력입니다. 다시 선택해주세요.")


if __name__ == "__main__":
    main()