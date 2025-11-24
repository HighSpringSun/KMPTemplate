package com.kmpstudy.data.database.dao
//
//import androidx.room.*
//import com.kmpstudy.data.database.entity.SleepRecordEntity
//import com.kmpstudy.domain.model.SleepRecord
//import kotlinx.coroutines.flow.Flow
//import kotlinx.datetime.LocalDate
//
//@Dao
//interface SleepRecordDao {
//
//    @RewriteQueriesToDropUnusedColumns
//    @Query("""
//        SELECT * FROM (
//            SELECT *, ROW_NUMBER() OVER(PARTITION BY date ORDER BY localId DESC) as rn
//            FROM sleep_records
//        ) WHERE rn = 1 ORDER BY date DESC
//    """)
//    fun getAllSleepRecords(): Flow<List<SleepRecordEntity>>
//
//    // 基本CRUD操作
//    @Query("SELECT * FROM sleep_records WHERE strftime('%Y-%m', date) = :yearMonthStr")
//    fun getSleepRecordsByYearMonth(yearMonthStr: String): Flow<List<SleepRecordEntity>>
//
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertSleepRecord(record: SleepRecordEntity): Long
//
//    @Update
//    suspend fun updateSleepRecord(record: SleepRecordEntity)
//
//    @Upsert
//    suspend fun upsertSleepRecord(record: SleepRecordEntity): Long
//
//    @Query("DELETE FROM sleep_records WHERE localId = :id")
//    suspend fun deleteSleepRecord(id: Int)
//
//    @Query("DELETE FROM sleep_records")
//    suspend fun clearAllSleepRecords()
//
//    //
////    @Query("SELECT * FROM sleep_records WHERE id = :id AND isDeleted = 0")
////    suspend fun getSleepRecordById(id: Long): SleepRecord?
////
//    @Query("SELECT * FROM sleep_records WHERE date = :date LIMIT 1")
//    suspend fun getSleepRecordByDate(date: LocalDate): SleepRecord?
////
//
//    @Query("SELECT COUNT(*) > 0 FROM sleep_records")
//    suspend fun hasLocalRecords(): Boolean
//
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun batchInsert(records: List<SleepRecordEntity>)
//
////
////    @Query("SELECT * FROM sleep_records WHERE isDeleted = 0 ORDER BY date DESC")
////    fun getAllSleepRecords(): Flow<List<SleepRecord>>
////
////    @Query(
////        """
////        SELECT * FROM sleep_records
////        WHERE date BETWEEN :startDate AND :endDate
////        AND isDeleted = 0
////        ORDER BY date DESC
////    """
////    )
////    suspend fun getSleepRecordsByDateRange(
////        startDate: LocalDate,
////        endDate: LocalDate
////    ): List<SleepRecord>
////
////    // 同步相关操作
////    @Query("SELECT * FROM sleep_records WHERE serverId = :serverId AND isDeleted = 0 LIMIT 1")
////    suspend fun getSleepRecordByServerId(serverId: String): SleepRecord?
////
////    @Query("SELECT * FROM sleep_records WHERE syncStatus = :status AND isDeleted = 0")
////    suspend fun getRecordsBySyncStatus(status: SyncStatus): List<SleepRecord>
////
////    @Query("UPDATE sleep_records SET syncStatus = :status WHERE id = :id")
////    suspend fun updateSyncStatus(id: Long, status: SyncStatus)
////
////    @Query(
////        """
////        UPDATE sleep_records
////        SET serverId = :serverId, syncStatus = :status, lastSyncedAt = datetime('now')
////        WHERE id = :id
////    ""
////    )
////    suspend fun markRecordAsSynced(id: Long, serverId: String, status: SyncStatus)
////
////    @Query(
////        """
////        SELECT * FROM sleep_records
////        WHERE updatedAt > :timestamp
////        AND isDeleted = 0
////        ORDER BY updatedAt DESC
////    ""
////    )
////    suspend fun getRecordsModifiedAfter(timestamp: LocalDateTime): List<SleepRecord>
////
////    // 用户相关操作
////    @Query("SELECT * FROM sleep_records WHERE userId = :userId AND isDeleted = 0 ORDER BY date DESC")
////    suspend fun getSleepRecordsByUserId(userId: String): List<SleepRecord>
////
////    @Query("UPDATE sleep_records SET isDeleted = 1 WHERE userId = :userId")
////    suspend fun deleteAllRecordsForUser(userId: String)
////
////    @Query("DELETE FROM sleep_records")
////    suspend fun clearAllRecords()
////
////    // 软删除操作
////    @Query("UPDATE sleep_records SET isDeleted = 1, syncStatus = :status WHERE id = :id")
////    suspend fun softDeleteRecord(id: Long, status: SyncStatus = SyncStatus.PENDING)
////
////    // 统计相关操作
////    @Query("SELECT COUNT(*) FROM sleep_records WHERE syncStatus = :status AND isDeleted = 0")
////    suspend fun getRecordCountBySyncStatus(status: SyncStatus): Int
////
////    @Query("SELECT COUNT(*) FROM sleep_records WHERE userId = :userId AND isDeleted = 0")
////    suspend fun getRecordCountByUserId(userId: String): Int
//}
