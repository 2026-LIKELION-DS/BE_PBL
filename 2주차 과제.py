baby_lions = []

while True:
    print("  1. 아기사자 등록")
    print("  2. 이름으로 검색")
    print("  3. 트랙별 조회")
    print("  0. 종료")
    choice = input("선택: ").strip()

    if choice == "1":
        name = input("이름: ").strip()
        track = input("트랙: ").strip()
        generation = input("기수: ").strip()
        baby_lions.append({"이름": name, "트랙": track, "기수": generation})
        print(f"'{name}' 등록 완료")

    elif choice == "2":
        name = input("이름: ").strip()
        result = []
        for lion in baby_lions:
            if lion["이름"] == name:
                result.append(lion)
        print(f"'{name}' 검색 결과 ({len(result)}명):")
        if not result:
            print("검색 결과가 없습니다.")
        for lion in result:
            print(f"  이름: {lion['이름']} | 트랙: {lion['트랙']} | 기수: {lion['기수']}")

    elif choice == "3":
        track = input("트랙명: ").strip()
        result = []
        for lion in baby_lions:
            if lion["트랙"] == track:
                result.append(lion)
        print(f"'{track}' 트랙 ({len(result)}명):")
        if not result:
            print("검색 결과가 없습니다.")
        for lion in result:
            print(f"  이름: {lion['이름']} | 트랙: {lion['트랙']} | 기수: {lion['기수']}")

    elif choice == "0":
        print("종료합니다.")
        break

    else:
        print("0~3 사이의 번호를 입력해주세요.")