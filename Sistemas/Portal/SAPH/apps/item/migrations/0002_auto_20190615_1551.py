# Generated by Django 2.2.1 on 2019-06-15 15:51

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('item', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='campo',
            name='nome',
            field=models.CharField(max_length=80),
        ),
        migrations.AlterField(
            model_name='item',
            name='nome',
            field=models.CharField(max_length=80),
        ),
    ]