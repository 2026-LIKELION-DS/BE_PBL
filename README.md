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

if **name** == "**main**":
main()

def register_lion(lions):
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

if **name** == "**main**":
main()

class Member:
def **init**(self, name):
if name == "":
raise ValueError
self.name = name

    def role(self):
        return ""

    def info(self):
        return ""

class Lion(Member):
def **init**(self, name, track, gen):
super().**init**(name)
if track == "" or gen == "":
raise ValueError
self.track = track
self.gen = gen

    def role(self):
        return "아기사자"

    def info(self):
        return self.name + " | " + self.track + " | " + self.gen

class Staff(Member):
def **init**(self, name):
super().**init**(name)

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
