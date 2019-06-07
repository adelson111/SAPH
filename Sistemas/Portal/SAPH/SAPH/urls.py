"""SAPH URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include
from apps.organizacao import urls as urls_organizacao
from apps.setor import urls as urls_setor
from apps.nivel import urls as urls_nivel
from apps.core import urls as urls_core
from apps.solicitacao import urls as urls_solicitacao
from apps.funcionario import urls as urls_funcionarios
from apps.delegacao import urls as urls_delegacao
from apps.item import urls as urls_item
from django.conf.urls.static import static
from SAPH import settings
# from django.contrib.auth.urls

urlpatterns = [
    path('', include(urls_core)),
    path('admin/', admin.site.urls),
    path('organizacao/', include(urls_organizacao)),
    path('setor/', include(urls_setor)),
    path('nivel/', include(urls_nivel)),
    path('funcionario/', include(urls_funcionarios)),
    path('solicitacao/', include(urls_solicitacao)),
    path('delegacao/', include(urls_delegacao)),
    path('item/', include(urls_item)),
    path('accounts/', include('django.contrib.auth.urls')),
    path('api-auth/', include('rest_framework.urls'))
] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
