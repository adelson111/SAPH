from django.contrib import admin

# Register your models here.
from apps.item.models import Item, Campo

admin.site.register(Item)
admin.site.register(Campo)