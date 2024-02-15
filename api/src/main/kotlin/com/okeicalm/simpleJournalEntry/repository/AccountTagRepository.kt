package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.AccountTag
import com.okeicalm.simpleJournalEntry.infra.db.tables.references.ACCOUNT_TAG
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

interface AccountTagRepository {
    fun findAll(): List<AccountTag>
    fun findById(id: Long): AccountTag?

    fun findByAccountId(accountId: Long): List<AccountTag>
    fun create(tag: AccountTag): AccountTag

    fun update(id: Long, name: String): AccountTag?
    fun delete(id: Long): Long
}

@Repository
class TagRepositoryImpl(private val dslContext: DSLContext) : AccountTagRepository {
    override fun findAll(): List<AccountTag> {
        return dslContext
            .select(
                ACCOUNT_TAG.ID,
                    ACCOUNT_TAG.NAME,
                    ACCOUNT_TAG.ACCOUNT_ID
            )
            .from(ACCOUNT_TAG)
            .fetch()
                .into(AccountTag::class.java)
    }

    override fun findById(id: Long): AccountTag? {
        return dslContext
            .fetchOne(ACCOUNT_TAG, ACCOUNT_TAG.ID.eq(id))
            ?.into(AccountTag::class.java)
    }
    // need a list-by-accounts

    override fun findByAccountId(accountId: Long): List<AccountTag> {
        return ArrayList()
    }

    override fun create(tag: AccountTag): AccountTag {
        // For AccountTag
        val record = dslContext
            .newRecord(ACCOUNT_TAG)
                .apply {
                    name = tag.name
                    accountId = tag.account_id
                }
        record.store()

        return tag.copy(id = record.id!!)
    }

    override fun update(id: Long, name: String): AccountTag? {
        var tag: AccountTag? = dslContext
                .fetchOne(ACCOUNT_TAG, ACCOUNT_TAG.ID.eq(id))
                ?.into(AccountTag::class.java)

        if (tag != null) {
            tag.name = name
            // save it
            dslContext.update(ACCOUNT_TAG)
                    .set(ACCOUNT_TAG.NAME, name)
                    .where(ACCOUNT_TAG.ID.eq(id))
                    .execute()
        }
        return tag
    }

    override fun delete(id: Long): Long {
        dslContext.delete(ACCOUNT_TAG)
                .where(ACCOUNT_TAG.ID.eq(id))
                .execute()
        return id
    }
}
