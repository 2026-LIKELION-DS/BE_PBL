def get_input(prompt):
    while True:
        value = input(prompt)
        if value and value.strip():
            return value.strip()
        print("유효하지 않은 입력입니다. 다시 입력해주세요.")

def collect(count):
    result = []
    for i in range(count):
        value = get_input(f"  [{i+1}/{count}] 입력: ")
        result.append(value)
    return result

def print_result(data):
    for i, value in enumerate(data, 1):
        print(f"  {i}. {value}")


count = int(get_input("몇 개의 문자열을 입력할까요? (숫자): "))
collected = collect(count)
print(f"\n수집된 문자열 ({len(collected)}개):")
print_result(collected)