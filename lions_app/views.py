from django.shortcuts import render, redirect, get_object_or_404
from .models import Lion

def lion_list(request):
    keyword = request.GET.get('keyword', '').strip()
    track_filter = request.GET.get('track', '').strip() 
    
    lions = Lion.objects.all().order_by('-created_at')
    
    if keyword:
        lions = lions.filter(name__icontains=keyword)
    if track_filter:
        lions = lions.filter(track=track_filter)
        
    return render(request, 'lions_app/list.html', {
        'lions': lions,
        'keyword': keyword,
        'track': track_filter  
    })

def lion_create(request):
    if request.method == 'POST':
        name = request.POST.get('name', '').strip()
        track = request.POST.get('track', '').strip()
        
        if not name:
            return render(request, 'lions_app/new.html', {'error_message': '이름을 입력해주세요.'})
            
        Lion.objects.create(name=name, track=track)
        return redirect('lions:lion_list') 
        
    return render(request, 'lions_app/new.html')

def lion_detail(request, lion_id):
    lion = get_object_or_404(Lion, id=lion_id)
    return render(request, 'lions_app/detail.html', {'lion': lion})

def lion_edit(request, lion_id):
    lion = get_object_or_404(Lion, id=lion_id)
    
    if request.method == 'POST':
        name = request.POST.get('name', '').strip()
        track = request.POST.get('track', '').strip()
        
        if name:
            lion.name = name
            lion.track = track
            lion.save()
            return redirect('lions:lion_detail', lion_id=lion.id) 
            
    return render(request, 'lions_app/edit.html', {'lion': lion})

def lion_delete(request, lion_id):
    lion = get_object_or_404(Lion, id=lion_id)
    if request.method == 'POST':
        lion.delete()
        return redirect('lions:lion_list')
    return redirect('lions:lion_list')

def home(request):
    return render(request, 'home.html')