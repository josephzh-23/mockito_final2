import com.example.mockito_final2.Inject_Mock.Dictionary
import com.example.mockito_final2.Inject_Mock.WordDictionary
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


/*
THis one currently is not working use mock_interaction
 */
@RunWith(MockitoJUnitRunner::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InjectMocksTest {


    @Mock
    private val wordMap: Map<String, String>? = null

    // Case 1 just the nonitnerface
   @InjectMocks
   private val nonInterface: WordDictionary?=null


    // Case 2: if we are using an interface
//    @InjectMocks
    //The reason we use instantiate is because dictionary is an interface
    // if not an interface then no need to do this
//    private val wordDictionary: Dictionary = WordDictionary()


    @BeforeAll
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun injectMocksTest() {
        Mockito.`when`<String>(wordMap?.get("awesome")).thenReturn("Very Good")
        /*
        In getMeaning, we are calling wordsMap.get("awesome") function
         */
        assertEquals("Very Good", nonInterface?.getMeaning("awesome"))
//        assertEquals("Very Good", nonInterface?.getMeaning("awesome"))

    }
}