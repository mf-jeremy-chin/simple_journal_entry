package com.okeicalm.simpleJournalEntry.handler.query

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.type.AccountTagType
import com.okeicalm.simpleJournalEntry.handler.type.AccountType
import com.okeicalm.simpleJournalEntry.repository.AccountRepository
import com.okeicalm.simpleJournalEntry.repository.AccountTagRepository
import org.springframework.stereotype.Component

@Component
class AccountQuery(private val accountRepository: AccountRepository, private val tagRepository: AccountTagRepository) : Query {
    fun allAccounts(): List<AccountType> {
        // adding tags to this should work, but... is that right? in terms of performance making it only query when
        // required would be better
        // what does that even look like in graphql?
        return accountRepository.findAll().map { AccountType(it) }
    }

    fun allAcountTags(): List<AccountTagType> {
        return tagRepository.findAll().map { AccountTagType(it) }
    }

    fun accountTags(accountId: ID):  List<AccountTagType> {
        return tagRepository.findByAccountId(accountId.toString().toLong()).map { AccountTagType(it) }
    }
}
