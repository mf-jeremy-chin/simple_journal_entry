package com.okeicalm.simpleJournalEntry.usecase.account

import com.okeicalm.simpleJournalEntry.entity.Account
import com.okeicalm.simpleJournalEntry.entity.AccountTag
import com.okeicalm.simpleJournalEntry.repository.AccountRepository
import com.okeicalm.simpleJournalEntry.repository.AccountTagRepository
import com.okeicalm.simpleJournalEntry.valueobject.AccountElementType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class AccountTagUpdateUseCaseInput(val id: Long, val name: String)
data class AccountTagUpdateUseCaseOutput(val account: AccountTag?)

interface AccountTagUpdateUseCase {
    fun call(input: AccountTagUpdateUseCaseInput): AccountTagUpdateUseCaseOutput
}

@Service
class AccountTagUpdateUseCaseImpl(private val accountTagRepository: AccountTagRepository) : AccountTagUpdateUseCase {
    @Transactional
    override fun call(input: AccountTagUpdateUseCaseInput): AccountTagUpdateUseCaseOutput {
        // hrmmm we don't care about account_id, can that be skipped?

        return AccountTagUpdateUseCaseOutput(accountTagRepository.update(input.id, input.name))
    }
}
