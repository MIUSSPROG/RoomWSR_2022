package com.example.roomwsr_2022.migrations

import androidx.room.DeleteColumn
import androidx.room.RenameColumn
import androidx.room.migration.AutoMigrationSpec

@RenameColumn(tableName = "Course", fromColumnName = "rating", toColumnName = "stars")
class MigrationRenameRatingToStar: AutoMigrationSpec

@DeleteColumn(tableName = "Course", columnName = "stars")
class MigrationDeleteColumnStars: AutoMigrationSpec