print("아기 사자 명단 관리 프로그램입니다.")
babylion_list = [] 

while True:
    babylion_name = input("아기 사자 이름을 입력하세요 (종료하려면 q 입력): ")

    if babylion_name == 'q':
        print("\n이름 입력을 종료합니다.")
        break
    elif babylion_name == "":
        print("이름이 비어있습니다. 다시 입력해 주세요.")
        continue
    else:
        babylion_list.append(babylion_name)
        print(f" '{babylion_name}' 이(가) 등록되었습니다.")

print("\n현재 아기 사자 명단입니다.")
for i in range(len(babylion_list)):
    print(f" {i+1}. {babylion_list[i]}")
