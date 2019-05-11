from django.urls import path

from apps.core.views import MyHome

urlpatterns = [
    path('', MyHome.as_view(), name="page_home"),

]