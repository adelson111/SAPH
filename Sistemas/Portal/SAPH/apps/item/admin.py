from django.contrib import admin

# Register your models here.
from apps.item.models import Item

admin.site.register(Item)