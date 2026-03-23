def input_like_lion():
    while True:
        name = input("아기 사자의 이름을 입력하세요 (종료하려면 q 입력): ").strip()

        if name.lower() == 'q':
            return 'q'
        if name == "":
            print("이름이 비어있습니다. 다시 입력해주세요.")
        else:
            return name

def main():
    print("아기 사자 명단 관리 프로그램입니다.")

    lions = []

    while True:
        name = input_like_lion()  

        if name == 'q':
            print("이름 입력을 종료합니다.\n")
            break

        lions.append(name)
        print(f"'{name}'이(가) 등록되었습니다.")

    print("현재 아기 사자 명단입니다.")
    for i, lion_name in enumerate(lions, start=1):
        print(f"{i}. {lion_name}")

if __name__ == "__main__":
    main()