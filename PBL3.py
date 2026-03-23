class Member:
    def __init__(self, name):
        if not name: raise ValueError("이름을 써주세요")
        self.name = name

class Lion(Member):
    def __init__(self, name, track, gen):
        super().__init__(name)
        if not gen or "기" not in gen:
            raise ValueError("기수를 'n기' 형식으로 입력해주세요.")
        self.track, self.gen = track, gen

class Staff(Member):
    def __init__(self, name):
        super().__init__(name)
        self.role = "운영진"

class Printer:
    def show_lion(self, lion):
        print(f" 아기사자: {lion.name} | {lion.track} | {lion.gen}")
        
    def show_staff(self, staff):
        print(f" 운영진: {staff.name} | 운영진")

class Sorter:
    def by_name(self, members):
        return sorted(members, key=lambda x: x.name)

members = []
p = Printer() 
s = Sorter()

while True:
    print("기능을 선택하세요")
    print("1. 사자 등록")
    print("2. 운영진 등록")
    print("3. 전체 출력")
    print("4.종료")
    choice = input("선택: ")

    try:
        if choice == '1':
            members.append(Lion(input("이름: "), input("트랙: "), input("기수: ")))
            print("아기사자가 등록되었습니다.")
            print("")
        elif choice == '2':
            members.append(Staff(input("이름: ")))
            print("운영진이 등록되었습니다.")
            print("")
        elif choice == '3':
            sorted_list = s.by_name(members)
            print("\n 멤버 목록")
            for m in sorted_list:
                if isinstance(m, Lion): p.show_lion(m)
                else: p.show_staff(m)
            print("")
        elif choice == '4':
            print("프로그램을 종료합니다.")
            break
    except ValueError as e:
        print(f" 에러: {e}")
