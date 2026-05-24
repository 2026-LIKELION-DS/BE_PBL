from django.urls import path
from . import views

app_name = 'lions'

urlpatterns = [
    path('', views.lion_list, name='lion_list'),
    path('new/', views.lion_create, name='lion_create'),
    path('<int:lion_id>/', views.lion_detail, name='lion_detail'),
    path('<int:lion_id>/edit/', views.lion_edit, name='lion_edit'),
    path('<int:lion_id>/delete/', views.lion_delete, name='lion_delete'),
]