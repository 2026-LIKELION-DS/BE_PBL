
class Member:
    def __init__(self, name):
        name=name.strip()
        if name == "":
            raise ValueError("이름은 비어있을 수 없습니다.")
        self.name=name
    def getrole(self):
        pass
    def display(self):
        pass

class Lion(Member):
    def __init__(self, name, track, num):
        super().__init__(name)
        track=track.strip()
        num=num.strip()
        if track == "":
            raise ValueError("트랙은 비어있을 수 없습니다.")
        if num == "":
            raise ValueError("기수는 비어있을 수 없습니다.")
        self.track=track
        self.num=num
    def display(self):
        return f"🦁 아기사자: 이름: {self.name}, 트랙: {self.track}, 기수: {self.num}"
    
    def getrole(self):
        return "아기사자"

class Staff(Member):
    def __init__(self, name):
        super().__init__(name)
    def getrole(self):
        return "운영진"
    def display(self):
        return f"🧑‍🏫 운영진: 이름: {self.name}, 역할: {self.getrole()}"
    
#정렬객체
class NameSorter:
    def sort(self, members):
        return sorted(members, key=lambda member: member.name)

class NumSorter:
    def sort(self, members):
        def sort_key(member):
            if isinstance(member, Lion):
                return int(member.num.replace("기", ""))
            return 9999
        return sorted(members, key=sort_key)

#출력객체
class Printer:
    def __init__(self, sorter):
        self.sorter = sorter

    def print_members(self, members):
        print("📋멤버 목록")
        sorted_members = self.sorter.sort(members)
        for member in sorted_members:
            print(member.display())


members=[]
printer = Printer(NameSorter())

while True:
    print("📌 기능을 선택하세요 \n 1️⃣  아기사자 등록 \n 2️⃣  운영진 등록 \n 3️⃣ 전체출력 \n 4️⃣  종료")
    choice=input("👉 선택:")
    if choice=="1":
        name=input("🦁 이름:")
        track=input("📚 트랙:")
        num=input("🎓 기수:")
        lion=Lion(name, track, num)
        members.append(lion)
        print("✅ 아기사자가 등록되었습니다.")

    elif choice=="2":
        name=input(" 🧑‍🏫 이름:")
        staff=Staff(name)
        members.append(staff)
        print("✅ 운영진이 등록되었습니다.")

    elif choice=="3":
        printer.print_members(members)

    elif choice=="4":
        print("📌 프로그램을 종료합니다.")
        break