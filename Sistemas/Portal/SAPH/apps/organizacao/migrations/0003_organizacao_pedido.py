# Generated by Django 2.2.1 on 2019-07-04 18:02

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('organizacao', '0002_auto_20190704_1124'),
    ]

    operations = [
        migrations.AddField(
            model_name='organizacao',
            name='pedido',
            field=models.BooleanField(default=False),
        ),
    ]