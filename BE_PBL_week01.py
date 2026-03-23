def main():
    names = []

    while True:
        name = input("아기 사자 이름을 입력하세요 (종료하려면 q 입력): ")

        if name == 'q':
            print("이름 입력을 종료합니다.")
            break

        if name.strip() == "":
            print("이름이 비어있습니다. 다시 입력해주세요.")
            continue

        names.append(name)
        print(f"'{name}' 이(가) 등록되었습니다.")

    print("\n현재 아기 사자 명단입니다.")
    for i, n in enumerate(names, 1):
        print(f"{i}. {n}")


main()