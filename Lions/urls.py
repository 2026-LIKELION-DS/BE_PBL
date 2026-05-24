from django.contrib import admin
from django.urls import path, include
from lions_app import views 


urlpatterns = [
    path('admin/', admin.site.urls),
    path('', views.home, name='home'),  
    path('lions/', include('lions_app.urls')),
]