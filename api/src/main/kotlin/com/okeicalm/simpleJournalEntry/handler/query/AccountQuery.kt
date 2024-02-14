package com.okeicalm.simpleJournalEntry.handler.query

import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.type.AccountTagType
import com.okeicalm.simpleJournalEntry.handler.type.AccountType
import com.okeicalm.simpleJournalEntry.repository.AccountRepository
import com.okeicalm.simpleJournalEntry.repository.AccountTagRepository
import org.springframework.stereotype.Component

@Component
class AccountQuery(private val repository: AccountRepository, private val repository2: AccountTagRepository) : Query {
    fun allAccounts(): List<AccountType> {
        return repository.findAll().map { AccountType(it) }
    }

    // uhhh this doesn't work quite right without a defined entity relationship
    // that's AccountRepository but .... can I inject another one?
    fun allAcountTags(): List<AccountTagType> {
        return repository2.findAll().map { AccountTagType(it) }
    }
}
