class Member:
    def __init__(self, name):
        if not name or not name.strip():
            raise ValueError("이름은 비어 있을 수 없습니다.")
        self.name = name.strip()

    def get_role(self):
        raise NotImplementedError

    def get_info(self):
        raise NotImplementedError


class Lion(Member):
    def __init__(self, name, track, generation):
        super().__init__(name)
        if not track or not track.strip():
            raise ValueError("트랙은 비어 있을 수 없습니다.")
        if not generation or not generation.strip().isdigit():
            raise ValueError("기수는 숫자여야 합니다.")
        self.track = track.strip()
        self.generation = int(generation.strip())

    def get_role(self):
        return "아기사자"

    def get_info(self):


class Staff(Member):
    def __init__(self, name, department):
        super().__init__(name)
        if not department or not department.strip():
            raise ValueError("부서는 비어 있을 수 없습니다.")
        self.department = department.strip()

    def get_role(self):
        return "운영진"

    def get_info(self):


class SortByName:
    def sort(self, data):
        return sorted(data, key=lambda m: m.name)

class SortByGeneration:
    def sort(self, data):
        return sorted(data, key=lambda m: m.generation)


class SimplePrint:
    def print_list(self, data):
        if not data:
            print("검색 결과가 없습니다.")
            return
        for i, m in enumerate(data, 1):
            info = m.get_info()
            print(f"  {i}. " + " | ".join(f"{k}: {v}" for k, v in info.items()))


members = []
sorter = SortByName()
printer = SimplePrint()

while True:
    print("\n────────────────────")
    print("  1. 아기사자 등록")
    print("  2. 운영진 등록")
    print("  3. 전체 목록")
    print("  0. 종료")
    print("────────────────────")
    choice = input("선택: ").strip()

    if choice == "1":
        try:
            name = input("이름: ").strip()
            track = input("트랙: ").strip()
            generation = input("기수(숫자): ").strip()
            members.append(Lion(name, track, generation))
            print(f"'{name}' 등록 완료")
        except ValueError as e:
            print(f"등록 실패: {e}")

    elif choice == "2":
        try:
            name = input("이름: ").strip()
            department = input("부서: ").strip()
            members.append(Staff(name, department))
            print(f"'{name}' 등록 완료")
        except ValueError as e:
            print(f"등록 실패: {e}")

    elif choice == "3":
        result = sorter.sort([m for m in members if isinstance(m, Lion)])
        print(f"전체 목록 ({len(result)}명):")
        printer.print_list(result)

    elif choice == "0":
        print("종료합니다.")
        break

    else:
        print("0~3 사이의 번호를 입력해주세요.")