package com.okeicalm.simpleJournalEntry.usecase.account

import com.okeicalm.simpleJournalEntry.entity.Account
import com.okeicalm.simpleJournalEntry.entity.AccountTag
import com.okeicalm.simpleJournalEntry.repository.AccountRepository
import com.okeicalm.simpleJournalEntry.repository.AccountTagRepository
import com.okeicalm.simpleJournalEntry.valueobject.AccountElementType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class AccountTagDeleteUseCaseInput(val id: Long)
data class AccountTagDeleteUseCaseOutput(val id: Long)

interface AccountTagDeleteUseCase {
    fun call(input: AccountTagDeleteUseCaseInput): AccountTagDeleteUseCaseOutput
}

@Service
class AccountTagDeleteUseCaseImpl(private val accountTagRepository: AccountTagRepository) : AccountTagDeleteUseCase {
    @Transactional
    override fun call(input: AccountTagDeleteUseCaseInput): AccountTagDeleteUseCaseOutput {
        // hrmmm we don't care about account_id, can that be skipped?

        return AccountTagDeleteUseCaseOutput(accountTagRepository.delete(input.id))
    }
}
