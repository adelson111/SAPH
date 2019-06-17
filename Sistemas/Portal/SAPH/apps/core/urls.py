from django.urls import path

from apps.core.views import MyHome, Exportar

urlpatterns = [
    path('', MyHome.as_view(), name="page_home"),
    path('exportar/', Exportar.as_view(), name="exportar")
]