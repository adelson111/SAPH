from django.urls import path


from .views import cadasrtrar

urlpatterns = [
    path('cadastrar/', cadasrtrar, name="cadasrtrar"),

]