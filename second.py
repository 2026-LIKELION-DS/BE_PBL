def register_lion(lions):
    """아기 사자 등록 함수"""
    name = input("이름을 입력하세요: ").strip()
    if not name:
        print("이름이 비어있습니다.")
        return
    track = input("트랙을 입력하세요: ").strip()
    if not track:
        print("트랙이 비어있습니다.")
        return
    batch = input("기수를 입력하세요: ").strip()
    if not batch:
        print("기수가 비어있습니다.")
        return


    lion = {"이름": name, "트랙": track, "기수": batch}
    lions.append(lion)
    print("아기사자가 등록되었습니다.\n")

def search_by_name(lions):
    """이름으로 아기사자 검색"""
    search_name = input("검색할 이름을 입력하세요: ").strip()
    found = [lion for lion in lions if lion["이름"] == search_name]

    if not found:
        print("해당 이름의 아기사자를 찾을 수 없습니다.\n")
        return

    print("\n검색 결과")
    for lion in found:
        print(f"이름: {lion['이름']}")
        print(f"트랙: {lion['트랙']}")
        print(f"기수: {lion['기수']}\n")

def filter_by_track(lions):
    """트랙별 아기사자 조회"""
    track_name = input("조회할 트랙을 입력하세요: ").strip()
    filtered = [lion for lion in lions if lion["트랙"] == track_name]

    if not filtered:
        print(f"{track_name} 트랙의 아기사자가 없습니다.\n")
        return

    print(f"\n{track_name} 트랙 아기사자 명단")
    for lion in filtered:
        print(f"- {lion['이름']} ({lion['기수']})")
    print()

def main():
    lions = []
    while True:
        print("기능을 선택하세요")
        print("1. 아기사자 등록")
        print("2. 이름으로 검색")
        print("3. 트랙으로 조회")
        print("4. 종료")
        choice = input("선택: ").strip()

        if choice == "1":
            register_lion(lions)
        elif choice == "2":
            search_by_name(lions)
        elif choice == "3":
            filter_by_track(lions)
        elif choice == "4":
            print("프로그램을 종료합니다.")
            break
        else:
            print("잘못된 입력입니다. 1~4 사이에서 선택해주세요.\n")

if __name__ == "__main__":
    main()