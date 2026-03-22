class Member:
    def __init__(self, name):
        if name == "":
            raise ValueError
        self.name = name

    def role(self):
        return ""

    def info(self):
        return ""


class Lion(Member):
    def __init__(self, name, track, gen):
        super().__init__(name)
        if track == "" or gen == "":
            raise ValueError
        self.track = track
        self.gen = gen

    def role(self):
        return "아기사자"

    def info(self):
        return self.name + " | " + self.track + " | " + self.gen


class Staff(Member):
    def __init__(self, name):
        super().__init__(name)

    def role(self):
        return "운영진"

    def info(self):
        return self.name + " | 운영진"


class Printer:
    def show(self, data):
        print("멤버 목록")
        for i in data:
            print("- " + i.role() + " : " + i.info())


members = []
p = Printer()

while True:
    print("1. 아기사자 등록")
    print("2. 운영진 등록")
    print("3. 전체 출력")
    print("4. 종료")
    c = input("선택: ")

    if c == "1":
        try:
            n = input("이름: ")
            t = input("트랙: ")
            g = input("기수: ")
            members.append(Lion(n, t, g))
            print("아기 사자가 등록되었습니다")
        except:
            print("입력 오류")

    elif c == "2":
        try:
            n = input("이름: ")
            members.append(Staff(n))
            print("운영진이 등록되었습니다")
        except:
            print("입력 오류")

    elif c == "3":
        p.show(members)

    elif c == "4":
        print("종료")
        break