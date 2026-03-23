# Member 부모 클래스
class Lions:
    def __init__(self, name):
        if not name.strip():
            raise ValueError("이름은 비어 있을 수 없습니다.")
        self.name = name

    def get_role(self):
        return "Member"


# 아기 사자 클래스
class Babylion(Lions):
    def __init__(self, name, track, generation):
        super().__init__(name)

        if not track.strip():
            raise ValueError("트랙은 비어 있을 수 없습니다.")

        if not isinstance(generation, int) or generation <= 0:
            raise ValueError("기수는 올바른 숫자여야 합니다.")

        self.track = track
        self.generation = generation

    def call_babylion(self):
        return "아기사자"

    def show_members(self):
        return f"{self.call_babylion()} : {self.name} | {self.track} | {self.generation}기"


#운영진 클래스
class Staff(Lions):
    def __init__(self, name):
        super().__init__(name)

    def call_staff(self):
        return "운영진"

    def show_members(self):
        return f"{self.call_staff()} : {self.name}"


# 출력
class ShowMembers:
    def print_all(self, members):
        print("\n멤버 목록")
        for m in members:
            print("-", m.show_members())


# 정렬 (람다)
class SortByName: #이름순
    def sort(self, members):
        return sorted(members, key=lambda x: x.name)


# 함수 메인
def main():
    members = []
    printer = ShowMembers()

    while True:
        print("\n 기능을 선택하세요")
        print("1. 아기사자 등록")
        print("2. 운영진 등록")
        print("3. 전체 출력")
        print("4. 종료")

        choice = input("-> 선택: ")

        try:
            if choice == "1":
                name = input("이름: ")
                track = input("트랙: ")
                generation = int(input("기수: "))

                babylion = Babylion(name, track, generation)
                members.append(babylion)

                print("아기사자가 등록되었습니다.")

            elif choice == "2":
                name = input("이름: ")

                staff = Staff(name)
                members.append(staff)

                print("운영진이 등록되었습니다.")

            elif choice == "3":
                # 정렬 함수 사용 (이름순)
                sorter = SortByName()
                sorted_members = sorter.sort(members)

                printer.print_all(sorted_members)

            elif choice == "4":
                print("프로그램을 종료합니다.")
                break

            else:
                print("올바른 선택이 아닙니다.")

        except ValueError as error:
            print(f"오류: {error}")

if __name__ == "__main__":
    main()