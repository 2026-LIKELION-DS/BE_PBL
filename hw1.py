
print("🦁 아기 사자 명단 관리 프로그램입니다.")

names=[]
while True: 
    x=input("✏️ 아기 사자 이름을 입력하세요(종료하려면 q 입력):")
    if x=="q":
        print("📌 이름 입력을 종료합니다.")
        break
    elif x== " ":
        print("⚠️ 이름이 비어있습니다. 다시 입력해주세요.")
    else:
        names.append(x)
        print(f"'✅ 아기사자{len(names)}'이(가) 등록되었습니다.")

print("📋 현재 아기 사자 명단입니다.")

for i in range(len(names)):
    print(f"🦁 {i+1}. {names[i]}")