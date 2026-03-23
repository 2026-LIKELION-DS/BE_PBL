
babylions=[]

#함수 선언부
def search_by_name(babylions, search_name):
    for babylion in babylions:
        if search_name==babylion["name"]:
            print(f"📋 검색 결과\n 이름: {babylion['name']}\n 트랙: {babylion['track']}\n 기수: {babylion['num']}\n\n")
            return babylion
    print("⚠️  해당 이름의 아기사자를 찾을 수 없습니다.")
    return None

def search_by_track(babylions, search_track):
    for babylion in babylions:
        if search_track==babylion["track"]:
            print(f"{babylion['name']} ({babylion['num']})")

            
#메인코드
while True:
    print("기능을 선택하세요\n 1. 아기사자 등록 \n 2. 이름으로 검색 \n 3. 트랙으로 조회 \n 4. 종료")
    choice = input("선택 :")
    if choice=="1":
        name=input("🦁 이름을 입력하세요:" )
        track=input("📚 트랙을 입력하세요:")
        num = input("🎓 기수를 입력하세요:")
        babylion={"name":name, "track":track, "num":num}
        babylions.append(babylion)
        print("✅ 아기사자가 등록되었습니다.")

    elif choice=="2":
        search_name=input("🔍 검색할 이름을 입력하세요:")
        search_by_name(babylions, search_name)
    elif choice=="3":
        search_track=input("📂 조회할 트랙을 입력하세요:")
        search_by_track(babylions, search_track)
    elif choice=="4":
        print("📌 프로그램을 종료합니다.")
        break